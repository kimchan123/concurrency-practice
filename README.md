# 동시성 문제 해결

## 1. Synchronized

## 2. Pessimistic Lock

- 장점
    - 충돌이 자주 일어나면 낙관적 락 보다 성능이 뛰어나다
    - 데이터의 정합성이 보장된다.
- 단점
    - 별도의 락이 필요해 성능이 좋지 않다.

## 3. Optimistic Lock

- 장점
    - 별도의 락을 잡지 않아 비관적 락 보다 성능이 뛰어나다.
- 단점
    - 실패했을 때 재시도 로직을 직접 작성해줘야 한다.

## 4. NamedLock

분산락을 구현할 때 사용

- 장점
    - timeout 구현이 쉽다
- 단점
    - transaction 종료 시 lock 해제와 session 관리를 잘 해줘야 함
    - 구현이 복잡함


