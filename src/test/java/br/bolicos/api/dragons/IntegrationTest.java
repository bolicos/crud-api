package br.bolicos.api.dragons;

import org.junit.jupiter.api.Tag;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.core.annotation.AliasFor;
import org.springframework.test.context.ActiveProfiles;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@WebFluxTest
@Tag("integration")
@ActiveProfiles("test")
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface IntegrationTest {

    /**
     * Specifies the controllers to test. This is an alias of {@link WebFluxTest#controllers()} which
     * can be used for brevity if no other attributes are defined. See
     * {@link WebFluxTest#controllers()} for details.
     *
     * @return the controllers to test
     * @see WebFluxTest#controllers()
     */
    @AliasFor(annotation = WebFluxTest.class)
    Class<?>[] value() default {};
}
