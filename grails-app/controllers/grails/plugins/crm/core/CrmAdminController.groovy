/*
 *  Copyright 2012 Goran Ehrsson.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */
package grails.plugins.crm.core

/**
 *
 * @author Goran Ehrsson
 * @since 0.1
 */
class CrmAdminController {

    static navigation = [
            [group: 'admin',
                    order: 900,
                    title: 'crmAdmin.label',
                    action: 'index'
            ],
            [group: 'crmAdmin',
                    order: 90,
                    title: 'crmAdmin.label',
                    action: 'index'
            ],
            [group: 'crmAdmin',
                    order: 95,
                    title: 'crmAdmin.jvm.label',
                    action: 'jvm'
            ]
    ]

    def crmCoreService

    def index() {
        def features = [:]
        for(f in crmCoreService.installedFeatures) {
            features[f] = crmCoreService.getFeature(f)
        }

        [features: features]
    }

    def jvm() {
    }
}
