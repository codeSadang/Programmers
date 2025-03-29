package _3월4주.할인행사;

public class 이태균 {

    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        int result = solution(want, number, discount);
        System.out.println(result);
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        PurchaseChecklist checklist = new PurchaseChecklist(want, number);

        // 10일 단위로 슬라이딩 윈도우 체크
        for (int start = 0; start <= discount.length - 10; start++) {
            // 10일간의 할인 품목 추출
            String[] tenDaysDiscount = new String[10];
            // System.arraycopy(원본 배열, 원본 배열의 시작 인덱스, 타겟 배열, 타겟 배열의 시작 인덱스, 복사할 요소의 개수
            System.arraycopy(discount, start, tenDaysDiscount, 0, 10);

            // 모든 제품 구매 가능하면 answer 증가
            if (checklist.checkPurchase(tenDaysDiscount)) {
                answer++;
            }
        }

        return answer;
    }

    // 구매 체크리스트 내부 클래스
    private static class PurchaseChecklist {
        private final String[] want;
        private final int[] number;

        public PurchaseChecklist(String[] want, int[] number) {
            this.want = want;
            this.number = number.clone();
        }

        // 할인 상품 확인 및 구매 처리
        public boolean checkPurchase(String[] discountItems) {
            // 남은 구매 수량 복사본 생성
            int[] number = this.number.clone(); // clone을 사용하지 않으면 number 배열 원본이 그대로 공유되는 문제가 발생할 수 있음

            // 10일간의 할인 품목 체크
            for (String item : discountItems) {
                for (int i = 0; i < want.length; i++) {
                    if (want[i].equals(item)) {
                        number[i]--;
                        break; // 원하는 제품 찾아서 반복 탈출
                    }
                }
            }

            // 모든 상품 구매 완료 여부 확인
            for (int num : number) {
                if (num > 0) {
                    return false;
                }
            }
            return true;
        }
    }

}