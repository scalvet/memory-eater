#setup

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
$ ./run.sh 

------------------------
running 128m_jvm_no_arg -> memory=128m -> arguments=-server
docker run --rm --name memory-eater --memory="128m" --memory-swap="128m" -e -server memory-eater #> 128m_jvm_no_arg.txt
VM settings:
    Max. Heap Size (Estimated): 61.88M
    Ergonomics Machine Class: server
    Using VM: OpenJDK 64-Bit Server VM

[freeMemory: 6.130393981933594MiB, totalMemory: 7.75MiB, maxMemory: 61.875MiB]
[freeMemory: 5.390068054199219MiB, totalMemory: 7.75MiB, maxMemory: 61.875MiB]
[freeMemory: 4.3485870361328125MiB, totalMemory: 7.75MiB, maxMemory: 61.875MiB]
...
[freeMemory: 2.2068099975585938MiB, totalMemory: 61.875MiB, maxMemory: 61.875MiB]
[freeMemory: 1.2067947387695312MiB, totalMemory: 61.875MiB, maxMemory: 61.875MiB]
[freeMemory: 0.5325469970703125MiB, totalMemory: 61.875MiB, maxMemory: 61.875MiB]
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        at es.profile.memeater.MainKt.main(Main.kt:6)
------------------------


------------------------
running 128m_jvm_Xmx128m -> memory=128m -> arguments=JAVA_TOOL_OPTIONS=-Xmx128m
docker run --rm --name memory-eater --memory="128m" --memory-swap="128m" -e JAVA_TOOL_OPTIONS=-Xmx128m memory-eater #> 128m_jvm_Xmx128m.txt
Picked up JAVA_TOOL_OPTIONS: -Xmx128m
VM settings:
    Max. Heap Size (Estimated): 123.75M
    Ergonomics Machine Class: server
    Using VM: OpenJDK 64-Bit Server VM

[freeMemory: 6.130393981933594MiB, totalMemory: 7.75MiB, maxMemory: 123.75MiB]
[freeMemory: 5.390068054199219MiB, totalMemory: 7.75MiB, maxMemory: 123.75MiB]
[freeMemory: 4.3485870361328125MiB, totalMemory: 7.75MiB, maxMemory: 123.75MiB]
...
[freeMemory: 18.74920654296875MiB, totalMemory: 123.75MiB, maxMemory: 123.75MiB]
[freeMemory: 17.749191284179688MiB, totalMemory: 123.75MiB, maxMemory: 123.75MiB]
[freeMemory: 16.749176025390625MiB, totalMemory: 123.75MiB, maxMemory: 123.75MiB]
------------------------


------------------------
running 128m_jvm_Xmx512m -> memory=128m -> arguments=JAVA_TOOL_OPTIONS=-Xmx512m
docker run --rm --name memory-eater --memory="128m" --memory-swap="128m" -e JAVA_TOOL_OPTIONS=-Xmx512m memory-eater #> 128m_jvm_Xmx512m.txt
Picked up JAVA_TOOL_OPTIONS: -Xmx512m
VM settings:
    Max. Heap Size (Estimated): 494.94M
    Ergonomics Machine Class: server
    Using VM: OpenJDK 64-Bit Server VM

[freeMemory: 6.130393981933594MiB, totalMemory: 7.75MiB, maxMemory: 494.9375MiB]
[freeMemory: 5.390068054199219MiB, totalMemory: 7.75MiB, maxMemory: 494.9375MiB]
[freeMemory: 4.3485870361328125MiB, totalMemory: 7.75MiB, maxMemory: 494.9375MiB]
...
[freeMemory: 63.694664001464844MiB, totalMemory: 177.30078125MiB, maxMemory: 494.9375MiB]
[freeMemory: 62.69464874267578MiB, totalMemory: 177.30078125MiB, maxMemory: 494.9375MiB]
[freeMemory: 61.69463348388672MiB, totalMemory: 177.30078125MiB, maxMemory: 494.9375MiB]
------------------------


------------------------
running 128m_jvm_75_percent -> memory=128m -> arguments=JAVA_TOOL_OPTIONS=-XX:MaxRAMPercentage=70.0 -XX:+UseG1GC -XX:+UseStringDeduplication -XX:MinRAMPercentage=10.0 -XX:ParallelGCThreads=1 -XX:+HeapDumpOnOutOfMemoryError 
docker run --rm --name memory-eater --memory="128m" --memory-swap="128m" -e JAVA_TOOL_OPTIONS=-XX:MaxRAMPercentage=70.0 -XX:+UseG1GC -XX:+UseStringDeduplication -XX:MinRAMPercentage=10.0 -XX:ParallelGCThreads=1 -XX:+HeapDumpOnOutOfMemoryError  memory-eater #> 128m_jvm_75_percent.txt
Picked up JAVA_TOOL_OPTIONS: -XX:MaxRAMPercentage=70.0 -XX:+UseG1GC -XX:+UseStringDeduplication -XX:MinRAMPercentage=10.0 -XX:ParallelGCThreads=1 -XX:+HeapDumpOnOutOfMemoryError 
VM settings:
    Max. Heap Size (Estimated): 14.00M
    Ergonomics Machine Class: server
    Using VM: OpenJDK 64-Bit Server VM

[freeMemory: 6.340766906738281MiB, totalMemory: 8.0MiB, maxMemory: 14.0MiB]
[freeMemory: 5.340751647949219MiB, totalMemory: 8.0MiB, maxMemory: 14.0MiB]
[freeMemory: 4.6092681884765625MiB, totalMemory: 8.0MiB, maxMemory: 14.0MiB]
[freeMemory: 5.5892333984375MiB, totalMemory: 10.0MiB, maxMemory: 14.0MiB]
[freeMemory: 6.5892181396484375MiB, totalMemory: 12.0MiB, maxMemory: 14.0MiB]
[freeMemory: 7.589202880859375MiB, totalMemory: 14.0MiB, maxMemory: 14.0MiB]
java.lang.OutOfMemoryError: Java heap space
Dumping heap to java_pid1.hprof ...
Heap dump file created [7396056 bytes in 0.020 secs]
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        at es.profile.memeater.MainKt.main(Main.kt:6)
------------------------


------------------------
running 128m_jvm_75_percent -> memory=128m -> arguments=JAVA_TOOL_OPTIONS=-XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMPercentage=75.0 -XX:+HeapDumpOnOutOfMemoryError
docker run --rm --name memory-eater --memory="128m" --memory-swap="128m" -e JAVA_TOOL_OPTIONS=-XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMPercentage=75.0 -XX:+HeapDumpOnOutOfMemoryError memory-eater #> 128m_jvm_75_percent.txt
Picked up JAVA_TOOL_OPTIONS: -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMPercentage=75.0 -XX:+HeapDumpOnOutOfMemoryError
VM settings:
    Max. Heap Size (Estimated): 61.88M
    Ergonomics Machine Class: server
    Using VM: OpenJDK 64-Bit Server VM

[freeMemory: 6.130393981933594MiB, totalMemory: 7.75MiB, maxMemory: 61.875MiB]
[freeMemory: 5.390068054199219MiB, totalMemory: 7.75MiB, maxMemory: 61.875MiB]
[freeMemory: 4.3485870361328125MiB, totalMemory: 7.75MiB, maxMemory: 61.875MiB]
...
[freeMemory: 2.2068099975585938MiB, totalMemory: 61.875MiB, maxMemory: 61.875MiB]
[freeMemory: 1.2067947387695312MiB, totalMemory: 61.875MiB, maxMemory: 61.875MiB]
[freeMemory: 0.5325469970703125MiB, totalMemory: 61.875MiB, maxMemory: 61.875MiB]
java.lang.OutOfMemoryError: Java heap space
Dumping heap to java_pid1.hprof ...
Heap dump file created [65047494 bytes in 0.174 secs]
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        at es.profile.memeater.MainKt.main(Main.kt:6)
------------------------

```