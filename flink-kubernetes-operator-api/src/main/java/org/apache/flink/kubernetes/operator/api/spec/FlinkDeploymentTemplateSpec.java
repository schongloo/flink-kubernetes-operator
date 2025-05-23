/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.kubernetes.operator.api.spec;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.LinkedHashMap;
import java.util.Map;

/** Template Spec that describes a Flink application managed by the blue/green controller. */
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class FlinkDeploymentTemplateSpec {

    @JsonProperty("metadata")
    private ObjectMeta metadata;

    @JsonProperty("deploymentDeletionDelaySec")
    private int deploymentDeletionDelaySec;

    @JsonProperty("maxNumRetries")
    private int maxNumRetries;

    @JsonProperty("reconciliationReschedulingIntervalMs")
    private int reconciliationReschedulingIntervalMs;

    @JsonProperty("spec")
    private FlinkDeploymentSpec spec;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
}
