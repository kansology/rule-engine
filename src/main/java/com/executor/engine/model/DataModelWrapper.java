package com.executor.engine.model;

import com.executor.engine.enums.Tasks;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by tarunkansal on 12/14/17.
 */
@Data
@AllArgsConstructor
public class DataModelWrapper {
    private DataModel model;
    private Tasks nextTask;
}
