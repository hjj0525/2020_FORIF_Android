3개의 intent로 이루어진 간단한 로그인 프로그램입니다.
-MainActivity
-LoginActivity
-RegActivity

[MainActivity]
login 버튼과 register 버튼이 있습니다.

login 버튼은 색이 변하는 image button으로 되어있습니다.
login에서는 아이디와 패스워드가 일치하는 경우에만 LoginActivity로 넘어갑니다.

register 버튼은 아무 조건없이 RegActivity로 이동합니다.

[LoginActivity]
login에 성공한 경우, MainActivity로부터 받은 ID값을 출력합니다.

[RegActivity]
회원 등록 기능을 하는 activity입니다.
아이디가 중복되는 경우 toast msg로 알려줍니다

회원 등록 후에는 DB에 들어갔는지 ID, PW, NAME, AGE 순으로 알려주며
Delete All을 누르면, DB에 저장된 데이터가 모두 삭제됩니다.


아무 입력 없이 버튼을 누르는 경우 등에서 버그가 있을 수 있습니다.
