package com.executor.engine.processor;

import com.executor.engine.model.DataModel;
import com.executor.engine.model.DataModelWrapper;

/**
 * Created by tarunkansal on 12/14/17.
 */
public interface BaseProcessor {
    DataModelWrapper execute (DataModel model);
}
