# Name: Spring Camel Sample 
Project sử dụng Spring Boot, Spock test với groovy.

# Purpose 
   
# Project Details  

# Getting Started
## Build
- Build trên terminal:
``$ cd {projectDir}``
- Lệnh build: 
``$ ./gradlew build``
- Lệnh run project spring boot: 
``$ ./gradlew bootRun``
- Khi chạy trên cmd, sẽ có log và đến dòng này tức là app đã khởi động thành công
``
2018-08-15 13:59:12 INFO  [restartedMain][App][59] Started App in 9.629 seconds (JVM running for 10.846)
``
- Khi tắt ứng dụng: (thao tác phím hoặc đóng cửa sổ terminal)
``ctrl + c``

## Testing
Chạy test:
```
Lệnh chạy terminal:
> $ ./gradlew test
```

Một test case với Spoc và Mock

```groovy
    given: 'prepare data'
    // Mock data
        
    when : 'test function'
    // call service
        
    then: 'expect the result'
    // assert result
```
#Author

```
Name: Pham Phuong Tu
Email: tupp@eway.vn
```
#Contributors
```
Name: Hoang Manh Tien
Email: tienhm@eway.vn
```

#Acknowledgments
```
Design pattern
Generic
```
