/**
 * Copyright 2015 Netflix, Inc.
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
package com.netflix.spectator.placeholders;

import com.netflix.spectator.api.Id;
import com.netflix.spectator.api.Registry;
import com.netflix.spectator.api.Tag;

import java.util.Collections;
import java.util.Map;

/**
 * PlaceholderId implementation for the no-op registry.
 *
 * Created on 8/27/15.
 */
final class NoopPlaceholderId implements PlaceholderId {
  /** Singleton instance. */
  static final PlaceholderId INSTANCE = new NoopPlaceholderId();

  private NoopPlaceholderId() {
  }

  @Override public String name() {
    return "noop";
  }

  @Override public Iterable<Tag> tags() {
    return Collections.emptyList();
  }

  @Override public PlaceholderId withTag(String k, String v) {
    return this;
  }

  @Override public PlaceholderId withTag(Tag tag) {
    return this;
  }

  @Override public PlaceholderId withTags(Iterable<Tag> tags) {
    return this;
  }

  @Override public PlaceholderId withTags(Map<String, String> tags) {
    return this;
  }

  @Override public String toString() {
    return name();
  }

  @Override public PlaceholderId withTagFactory(TagFactory factory) {
    return this;
  }

  @Override public PlaceholderId withTagFactories(Iterable<TagFactory> factories) {
    return this;
  }

  @Override public Id resolveToId(Registry registry) {
    return registry.createId(name(), tags());
  }
}
