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

package grails.plugins.crm.core

import spock.lang.Specification

/**
 * Test CrmLookupEntity abstract domain.
 */
class CrmLookupEntitySpec extends Specification {

    def "test toString"() {
        expect:
        new TestLookupEntity(name: "foo").toString() == 'foo'
    }

    def "test equals"() {
        when:
        def t1 = new TestLookupEntity(orderIndex: 1, name: "foo")
        def t2 = new TestLookupEntity(orderIndex: 1, name: "foo")
        def t3 = new TestLookupEntity(orderIndex: 2, name: "foo")
        def t4 = new TestLookupEntity(orderIndex: 1, name: "bar")

        then:
        t1 == t2
        t1 != t3
        t1 != t4
    }

    def "test hashCode"() {
        when:
        def t1 = new TestLookupEntity(orderIndex: 1, name: "foo")
        def t2 = new TestLookupEntity(orderIndex: 1, name: "foo")
        def t3 = new TestLookupEntity(orderIndex: 2, name: "foo")
        def t4 = new TestLookupEntity(orderIndex: 1, name: "bar")

        then:
        t1.hashCode() == t2.hashCode()
        t1.hashCode() != t3.hashCode()
        t1.hashCode() != t4.hashCode()
    }

    def "sort on orderIndex"() {
        given:
        def list = []
        list << new TestLookupEntity(id: 60, name: "Red", orderIndex: 1)
        list << new TestLookupEntity(id: 50, name: "Green", orderIndex: 4)
        list << new TestLookupEntity(id: 10, name: "Blue", orderIndex: 3)
        list << new TestLookupEntity(id: 30, name: "Yellow", orderIndex: 5)
        list << new TestLookupEntity(id: 20, name: "Black", orderIndex: 2)
        list << new TestLookupEntity(id: 40, name: "White", orderIndex: 6)

        when:
        def sortedList = list.sort(CrmLookupEntity.COMPARATOR)*.orderIndex

        then:
        sortedList == [1, 2, 3, 4, 5, 6]
    }
}
