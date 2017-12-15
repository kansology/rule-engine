package com.executor.engine.service;

import com.executor.engine.enums.Tasks;
import com.executor.engine.model.DataModel;
import com.executor.engine.model.DataModelWrapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeoutException;

import static org.junit.Assert.*;

/**
 * Created by tarunkansal on 12/14/17.
 */
public class RuleEngineExecutorServiceTest {

    RuleEngineExecutorService service = new RuleEngineExecutorService();

    @Test(expected = TimeoutException.class)
    public void test_executeThrowException() throws Exception {
        service.execute((long) 12000, new DataModelWrapper(new DataModel("Process One"), Tasks.PROCESS_ONE));
    }

    @Test
    public void test_executeCompleteSuccessfully() throws Exception {
        service.execute((long) 5000, new DataModelWrapper(new DataModel("Process One"), Tasks.PROCESS_ONE));
    }

}