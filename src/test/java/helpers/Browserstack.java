package helpers;


import static io.restassured.RestAssured.given;

public class Browserstack {
        public static String videoUrl(String sessionId) {
            return given()
                    .auth().basic("killinginside_6pruSi", "vgYsDg5zSSqrFPi3YpNV")
                    .when()
                    .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId +".json")
                    .then()
                    .statusCode(200)
                    .log().body()
                    .extract()
                    .response()
                    .path("automation_session.video_url");

    }

}
