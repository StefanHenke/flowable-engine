/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may
 * obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under the License.
 */
package org.activiti.engine.impl.cfg.multitenant;

import org.activiti.engine.ActivitiException;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.interceptor.CommandInterceptor;
import org.activiti.engine.impl.persistence.StrongUuidGenerator;

public class MultiSchemaMultiTenantProcessEngineConfiguration extends ProcessEngineConfigurationImpl {

    public MultiSchemaMultiTenantProcessEngineConfiguration() {
        // Using the UUID generator, as otherwise the ids are pulled from a global pool of ids, backed by
        // a database table. Which is impossible with a multi-database-schema setup.

        // Also: it avoids the need for having a process definition cache for each tenant
        this.idGenerator = new StrongUuidGenerator();
    }

    @Override
    public ProcessEngine buildProcessEngine() {
        if (databaseType == null) {
            throw new ActivitiException(
                    "Setting the databaseType is mandatory when using MultiSchemaMultiTenantProcessEngineConfiguration");
        }

        return super.buildProcessEngine();
    }

    @Override
    protected CommandInterceptor createTransactionInterceptor() {
        return null;
    }

}
