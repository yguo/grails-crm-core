/*
 * Copyright 2013 Goran Ehrsson.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package grails.plugins.crm.core;

import java.util.List;

/**
 * Checked exception for use in transactional contexts whe rollback is not wanted.
 */
public class CrmCheckedException extends Exception {

    private List args;

    public CrmCheckedException(String s) {
        super(s);
    }

    public CrmCheckedException(String s, List args) {
        super(s);
        this.args = args;
    }

    public CrmCheckedException(String s, List args, Throwable throwable) {
        super(s, throwable);
        this.args = args;
    }

    public List getArgs() {
        return args;
    }
}
