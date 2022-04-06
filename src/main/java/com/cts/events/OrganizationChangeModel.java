package com.cts.events;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class OrganizationChangeModel {

    private String type;
    private String action;
    private Long organizationId;
    private String correlationId;
}
