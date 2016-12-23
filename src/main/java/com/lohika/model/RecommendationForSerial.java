package com.lohika.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Evegeny on 23/12/2016.
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecommendationForSerial {
    private int positiveUsers;
    private long totalUsers;
}
