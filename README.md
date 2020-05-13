# setup

```shell script
$ cat /etc/default/grub | grep GRUB_CMDLINE_LINUX
GRUB_CMDLINE_LINUX_DEFAULT="quiet splash"
GRUB_CMDLINE_LINUX=""
$ sudo vi  /etc/default/grub 
$ cat /etc/default/grub |grep GRUB_CMDLINE_LINUX
GRUB_CMDLINE_LINUX_DEFAULT="maybe-ubiquity"
GRUB_CMDLINE_LINUX="cgroup_enable=memory swapaccount=1"
$ sudo update-grub
```


```shell script
./run.sh

------------------------
running 128m_jvm_no_arg -> memory=128m -> arguments=
docker run --rm --name memory-eater --memory="${memory}" --memory-swap="${memory}" ${env_arg} "${args}" memory-eater > ${conf_name}.txt
docker: invalid reference format.
See 'docker run --help'.
------------------------


------------------------
running 128m_jvm_Xmx128m -> memory=128m -> arguments=JAVA_TOOL_OPTIONS=-Xmx128m
docker run --rm --name memory-eater --memory="${memory}" --memory-swap="${memory}" ${env_arg} "${args}" memory-eater > ${conf_name}.txt
WARNING: Your kernel does not support swap limit capabilities or the cgroup is not mounted. Memory limited without swap.
Picked up JAVA_TOOL_OPTIONS: -Xmx128m
VM settings:
    Max. Heap Size (Estimated): 123.75M
    Ergonomics Machine Class: server
    Using VM: OpenJDK 64-Bit Server VM

Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        at es.profile.memeater.MainKt.main(Main.kt:6)
------------------------


------------------------
running 128m_jvm_Xmx128m -> memory=128m -> arguments=JAVA_TOOL_OPTIONS=-Xmx512m
docker run --rm --name memory-eater --memory="${memory}" --memory-swap="${memory}" ${env_arg} "${args}" memory-eater > ${conf_name}.txt
WARNING: Your kernel does not support swap limit capabilities or the cgroup is not mounted. Memory limited without swap.
Picked up JAVA_TOOL_OPTIONS: -Xmx512m
VM settings:
    Max. Heap Size (Estimated): 494.94M
    Ergonomics Machine Class: server
    Using VM: OpenJDK 64-Bit Server VM

Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        at es.profile.memeater.MainKt.main(Main.kt:6)
------------------------


------------------------
running 128m_jvm_75_percent -> memory=128m -> arguments=JAVA_TOOL_OPTIONS=-XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMPercentage=75.0 -XX:+HeapDumpOnOutOfMemoryError
docker run --rm --name memory-eater --memory="${memory}" --memory-swap="${memory}" ${env_arg} "${args}" memory-eater > ${conf_name}.txt
WARNING: Your kernel does not support swap limit capabilities or the cgroup is not mounted. Memory limited without swap.
Picked up JAVA_TOOL_OPTIONS: -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMPercentage=75.0 -XX:+HeapDumpOnOutOfMemoryError
VM settings:
    Max. Heap Size (Estimated): 61.88M
    Ergonomics Machine Class: server
    Using VM: OpenJDK 64-Bit Server VM

Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        at es.profile.memeater.MainKt.main(Main.kt:6)
------------------------



```
