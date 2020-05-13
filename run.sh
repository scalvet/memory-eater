#!/bin/bash

function run_docker {
conf_name="${1}"
memory="${2}"
args="${3}"

if [ -z "${args}" ]
then
args="-server"
fi

echo ""
echo "------------------------"
echo "running ${conf_name} -> memory=${memory} -> arguments=${args}";
echo 'docker run --rm --name memory-eater --memory="'${memory}'" --memory-swap="'${memory}'" -e '${args}' memory-eater #> '${conf_name}'.txt'
docker run --rm --name memory-eater --memory="${memory}" --memory-swap="${memory}" -e "${args}" memory-eater #> ${conf_name}.txt
echo "------------------------"
echo ""
}
run_docker "128m_jvm_no_arg" "128m" ""
run_docker "128m_jvm_Xmx128m" "128m" "JAVA_TOOL_OPTIONS=-Xmx128m"
run_docker "128m_jvm_Xmx512m" "128m" "JAVA_TOOL_OPTIONS=-Xmx512m"
run_docker "128m_jvm_75_percent" "128m" "JAVA_TOOL_OPTIONS=-XX:MaxRAMPercentage=70.0 -XX:+UseG1GC -XX:+UseStringDeduplication -XX:MinRAMPercentage=10.0 -XX:ParallelGCThreads=1 -XX:+HeapDumpOnOutOfMemoryError "
run_docker "128m_jvm_75_percent" "128m" "JAVA_TOOL_OPTIONS=-XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMPercentage=75.0 -XX:+HeapDumpOnOutOfMemoryError"


