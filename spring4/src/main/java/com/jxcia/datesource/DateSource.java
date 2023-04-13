package com.jxcia.datesource;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component("dateSource")
public class DateSource {
    @Value("${jdbc.driver}")
    private String driverClass;
//    @Value("jdbc:mysql://127.0.0.0:3306/user")
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
}
