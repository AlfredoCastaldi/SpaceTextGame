package org.example.scenari;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SceneAnnotation {
    

    String sceneName();
}
