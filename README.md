# Spring Security 처리 과정

1. 사용자가 아이디 비밀번호로 로그인을 요청한다.
2. AuthenticationFilter에서 UsernamePasswordAuthenticationToken을 생성하여 AuthenticaionManager에게 전달한다.
3. AuthenticaionManager는 등록된 AuthenticaionProvider(들)을 조회하여 인증을 요구한다.
4. AuthenticaionProvider는 UserDetailsService를 통해 입력받은 아이디에 대한 사용자 정보를 DB에서 조회한다.
5. 입력받은 비밀번호를 암호화하여 DB의 비밀번호화 매칭되는 경우 인증이 성공된 UsernameAuthenticationToken을 생성하여 AuthenticaionManager로 반환한다.
6. AuthenticaionManager는 UsernameAuthenticaionToken을 AuthenticaionFilter로 전달한다.
7. AuthenticationFilter는 전달받은 UsernameAuthenticationToken을 LoginSuccessHandler로 전송하고, SecurityContextHolder에 저장한다.