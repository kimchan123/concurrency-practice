# 동시성 문제 해결

## 1. Synchronized

## 2. Pessimistic Lock

- 장점
    - 충돌이 자주 일어나면 낙관적 락 보다 성능이 뛰어나다
    - 데이터의 정합성이 보장된다.
- 단점
    - 별도의 락이 필요해 성능이 좋지 않다.

## 3. Optimistic Lock

