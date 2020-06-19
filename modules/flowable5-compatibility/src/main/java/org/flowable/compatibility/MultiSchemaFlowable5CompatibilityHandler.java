package org.flowable.compatibility;


public class MultiSchemaFlowable5CompatibilityHandler extends DefaultFlowable5CompatibilityHandler {

    @Override
    public DefaultProcessEngineFactory getProcessEngineFactory() {
        if (processEngineFactory == null) {
            processEngineFactory = new MultiSchemaFlowable5ProcessEngineFactory();
        }
        return processEngineFactory;
    }
}
