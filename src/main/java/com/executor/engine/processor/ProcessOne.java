package com.executor.engine.processor;

import com.executor.engine.enums.Tasks;
import com.executor.engine.model.DataModel;
import com.executor.engine.model.DataModelWrapper;

/**
 * Created by tarunkansal on 12/14/17.
 */
public class ProcessOne implements BaseProcessor {
    @Override
    public DataModelWrapper execute(DataModel model) {
        System.out.println("model = [" + model + "]");
        model.setName("Process Two");
        return new DataModelWrapper(model, Tasks.PROCESS_TWO);
    }
}
