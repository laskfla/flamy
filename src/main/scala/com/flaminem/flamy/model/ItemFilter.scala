/*
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
 *
 */

package com.flaminem.flamy.model

import com.flaminem.flamy.model.names.ItemName

/**
 * Created by fpin on 1/9/15.
 */
case class ItemFilter(items: Traversable[ItemName], acceptIfEmpty: Boolean) extends ((ItemName) => Boolean) {

  override def apply(item: ItemName): Boolean = {
    if (acceptIfEmpty && items.isEmpty) {
      true
    }
    else {
      items.exists{case i => item.isInOrEqual(i) || i.isInOrEqual(item)}
    }
  }

}
