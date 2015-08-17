/**
 *
 * @author Wei-Ming Wu
 *
 *
 * Copyright 2015 Wei-Ming Wu
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 */
package com.github.wnameless.spring.batchapi;

import org.springframework.http.HttpStatus;

public final class BatchApiException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private final HttpStatus status;
  private final String error;

  public BatchApiException(HttpStatus status, String error) {
    if (status == null) throw new NullPointerException();
    if (error == null) throw new NullPointerException();

    this.status = status;
    this.error = error;
  }

  public HttpStatus getStatus() {
    return status;
  }

  public String getError() {
    return error;
  }

  @Override
  public int hashCode() {
    int result = 27;

    result = result ^ 31 + status.hashCode();
    result = result ^ 31 + error.hashCode();

    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null) return false;

    BatchApiException ex = (BatchApiException) obj;

    return ex.status.equals(status) && ex.error.equals(error);
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + "{status=" + status + ", error=" + error
        + "}";
  }

}
