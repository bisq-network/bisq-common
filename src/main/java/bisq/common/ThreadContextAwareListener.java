/*
 * This file is part of Bisq.
 *
 * Bisq is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * Bisq is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Bisq. If not, see <http://www.gnu.org/licenses/>.
 */

package bisq.common;

import java.util.concurrent.Executor;

/**
 * Used for supporting to define the thread in which the listener is executed.
 */
public interface ThreadContextAwareListener {
    // Default executor used for calling the handlers is user thread.
    // Listener who want to get called in a custom thread need to overwrite that method.
    default Executor getExecutor() {
        return UserThread.getExecutor();
    }

    default void execute(Runnable runnable) {
        getExecutor().execute(runnable);
    }
}
