package net.kang.gateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GatewayApplication

// 정말이지만... 이거만 실행하면 게이트웨이 기능은 '기본적으로' 작동할 수 있게 해준다.
fun main(args: Array<String>) {
    runApplication<GatewayApplication>(*args)
}
