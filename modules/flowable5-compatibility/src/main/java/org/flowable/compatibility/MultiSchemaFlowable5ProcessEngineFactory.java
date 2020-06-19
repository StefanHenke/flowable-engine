package org.flowable.compatibility;

import org.activiti.engine.ProcessEngine;
import org.flowable.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.flowable.engine.impl.cfg.multitenant.MultiSchemaMultiTenantProcessEngineConfiguration;

public class MultiSchemaFlowable5ProcessEngineFactory extends DefaultProcessEngineFactory {

    /**
     * Takes in an Activiti 6 process engine config, gives back an Activiti 5 Process engine.
     */
    @Override
    public ProcessEngine buildProcessEngine(ProcessEngineConfigurationImpl activiti6Configuration) {
        if (activiti6Configuration instanceof MultiSchemaMultiTenantProcessEngineConfiguration) {
            org.activiti.engine.impl.cfg.multitenant.MultiSchemaMultiTenantProcessEngineConfiguration activiti5Configuration = //
                    new org.activiti.engine.impl.cfg.multitenant.MultiSchemaMultiTenantProcessEngineConfiguration();
            super.copyConfigItems(activiti6Configuration, activiti5Configuration);
            activiti5Configuration.setDatabaseType(activiti6Configuration.getDatabaseType());


            return activiti5Configuration.buildProcessEngine();
        } else {
            return super.buildProcessEngine(activiti6Configuration);
        }
    }

}
