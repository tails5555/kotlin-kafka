# Spring Boot with Kafka

- Inventory : 재고 물품을 보관하는 창고 관리 모듈
- Order : 상품을 주문하기 위한 모듈
- Gateway : 재고, 상품 서비스를 한 번에 접속하기 위한 게이트웨이.
  - 설정만 구현하면 되지만, 실제로 이를 어떻게 작동하는지 파악하는게 관건인 거 같다.

## Reference
  * [Kafka Mac 에 설치하기](https://dev-jj.tistory.com/entry/MAC-Kafka-%EB%A7%A5%EC%97%90-Kafka-%EC%84%A4%EC%B9%98-%ED%95%98%EA%B8%B0-Docker-homebrew-Apache)
  * [데이터 동기화를 위한 Kafka 활용](https://tmdrl5779.tistory.com/190)

## 실행 방법

- Kafka 를 다운 받아, Zookeeper -> Kafka 순으로 실행한다.
- Inventory, Order 모듈의 ~~~ Application.kt 로 실행
- Gateway ~~~ Application.kt 실행
- 각 주소는 localhost:8080/order/data 및 localhost:8080/inventory/data (GET/POST) 로 되어 있음.