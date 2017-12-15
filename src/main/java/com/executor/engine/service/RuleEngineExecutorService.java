package com.executor.engine.service;

import com.executor.engine.model.DataModelWrapper;
import com.executor.engine.processor.BaseProcessor;

import java.util.concurrent.*;

/**
 * Created by tarunkansal on 12/14/17.
 */
public class RuleEngineExecutorService {

    public void execute(Long sleepTime, DataModelWrapper wrapper) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        final DataModelWrapper[] wrapperFinal = {wrapper};

        Runnable ruleEngine = () -> {
            System.out.println("Inside the engine");
            while(wrapperFinal[0].getNextTask() != null) {
                try {
                    BaseProcessor processor = (BaseProcessor) wrapperFinal[0].getNextTask().getProcessClass().newInstance();
                    wrapperFinal[0] = processor.execute(wrapperFinal[0].getModel());
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        };

        Future future = executor.submit(ruleEngine);

        try {
            future.get(10000, TimeUnit.MILLISECONDS);
            System.out.println("task complete in time...");
        } catch (InterruptedException | ExecutionException| TimeoutException e) {
            System.out.println("Cancelling task...");
            future.cancel(true);
            throw e;
        }
    }
}
