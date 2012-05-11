/*
 * Copyright (c) 2012 Goran Ehrsson.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */

import grails.plugins.crm.core.TenantUtils

/**
 *
 * @author Goran Ehrsson
 * @since 0.1
 */
class CrmTenantFilters {

    def crmSecurityService

    def filters = {
        tenantCheck(uri: '/**') {
            before = {
                // If tenant parameter is specified in the request then use it.
                // Necessary permission checks are performed by application logic.
                def tenant = params.long('tenant')
                if (!tenant) {
                    tenant = TenantUtils.tenant
                    if (!tenant) {
                        if(session != null) {
                            tenant = session.tenant
                        }
                        if (tenant == null) {
                            tenant = 0L
                        }
                    }
                }
                TenantUtils.setTenant(tenant)
            }
        }
    }
}
