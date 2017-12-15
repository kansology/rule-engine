package com.executor.engine.processor;

import com.executor.engine.enums.Tasks;
import com.executor.engine.model.DataModel;
import com.executor.engine.model.DataModelWrapper;

/**
 * Created by tarunkansal on 12/14/17.
 */
public class ProcessTwo implements BaseProcessor {

    @Override
    public DataModelWrapper execute(DataModel model) {
        System.out.println("model = [" + model + "]");
        return new DataModelWrapper(model, null);
    }
}
