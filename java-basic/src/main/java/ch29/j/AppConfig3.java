package ch29.j;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

//@Configuration
@ComponentScan(
    basePackages={"ch29.j2","ch29.j"},
    excludeFilters= {
        @ComponentScan.Filter(
        type=FilterType.REGEX,
        pattern="ch29.j.Car"
        ), @ComponentScan.Filter(
            type=FilterType.REGEX,
            pattern="ch29.j.AppConfig2"
            )
    }
    )
public class AppConfig3 {

}
