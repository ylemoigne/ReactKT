/*
 * Copyright 2015 Yann Le Moigne
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fr.javatic.reactktSample.core

import fr.javatic.reactktSample.core.interfaces.Todo
import kotlin.browser.localStorage

object Utils {
    fun uuid(): String {
        var uuid = "";

        for (i in 0..32) {
            val random = (Math.random() * 16).toInt().or(0)
            if (i === 8 || i === 12 || i === 16 || i === 20) {
                uuid += '-';
            }
            uuid += (if (i == 12) 4 else (if (i == 16) (random.and(3 or 8)) else random))
        }

        return uuid;
    }

    fun pluralize(count: Number, word: String): String {
        return if (count == 1) word else word + "s"
    }

    fun store(namespace: String, dat: Any): Unit {
        localStorage.setItem(namespace, JSON.stringify(dat));
    }

    fun store(namespace: String): List<Todo> {
        val store = localStorage.getItem(namespace);

        return if (store != null) {
            val ar: Array<Todo> = JSON.parse(store)
            ar.toList()
        } else listOf();
    }

    //    fun extend(...objs : any[]) : any {
    //        var newObj = {};
    //        for (var i = 0; i < objs.length; i++) {
    //            var obj = objs[i];
    //            for (var key in obj) {
    //                if (obj.hasOwnProperty(key)) {
    //                    newObj[key] = obj[key];
    //                }
    //            }
    //        }
    //        return newObj;
    //    }
}