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

/**
 * Used for supporting to define the thread in which the listener is executed.
 */
public interface ThreadAwareListener {
    // If overwritten and false is returned the caller will map to the userThread, otherwise it will be called directly
    // from the running thread. We do not user executor.execute() as we don't want to wait until the running task is
    // completed.
    default boolean executeOnUserThread() {
        return true;
    }

    default void execute(Runnable runnable) {
        if (executeOnUserThread())
            UserThread.execute(runnable);
        else
            runnable.run();
    }
}
