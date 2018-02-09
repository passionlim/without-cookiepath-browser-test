

## Sample 을

## Running a web server
----
run_no_path.sh : Path 없이 Cookie 를 생성하는 경우. JSESSIONID 쿠키 유실 발생함
run_root_path.sh : ROOT(/) Path로 Cookie 를 생성하는 경우
----

## 테스트 결과
 IE 에서는 Cookie 유실이 좀 더 빨리 일어남을 확인할 수 있음.

### Path 없을 경우

#### Chrome
 250번째 쯤 쿠키(JSESSIONID) 유실 발생
 ![Chrome](/images/chrome_no_path_cookie.png)

#### IE
 ![Chrome](/images/ie_no_path_cookie.png)

### Path 없을 경우
Set-Cookie 에 Path 값이 있을 경우 브라우저별 이슈 발생 안함

#### Chrome
![Chrome](/images/chrome_root_path_cookie.png)

#### IE
![Chrome](/images/chrome_root_path_cookie.png)
