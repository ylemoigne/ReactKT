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
// Based off https://github.com/ForbesLindesay/umd/blob/master/template.js
;(function (f) {
    // CommonJS
    if (typeof exports === "object" && typeof module !== "undefined") {
        module.exports = f(require('react'));

        // RequireJS
    } else if (typeof define === "function" && define.amd) {
        define(['react'], f);

        // <script>
    } else {
        var g
        if (typeof window !== "undefined") {
            g = window;
        } else if (typeof global !== "undefined") {
            g = global;
        } else if (typeof self !== "undefined") {
            g = self;
        } else {
            // works providing we're not in "use strict";
            // needed for Java 8 Nashorn
            // see https://github.com/facebook/react/issues/3037
            g = this;
        }
        g.ReactDOM = f(g.React);
    }

})(function (React) {
    return React.__SECRET_DOM_DO_NOT_USE_OR_YOU_WILL_BE_FIRED;
});
