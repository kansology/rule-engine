package com.executor.engine.enums;

import com.executor.engine.processor.ProcessOne;
import com.executor.engine.processor.ProcessTwo;
import lombok.Getter;

/**
 * Created by tarunkansal on 12/14/17.
 */
@Getter
public enum Tasks {
    PROCESS_ONE(ProcessOne.class, "This is Process one"),
    PROCESS_TWO(ProcessTwo.class, "This is process two");

    private Class processClass;
    private String description;
    Tasks(Class<?> processClass, String description) {
        this.processClass = processClass;
        this.description = description;
    }
}
