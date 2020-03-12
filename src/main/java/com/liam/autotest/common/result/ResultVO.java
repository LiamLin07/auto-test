package com.liam.autotest.common.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO<T> {
    private Integer code;
    private String msg;
    private T data;
}
