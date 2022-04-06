package com.cts.events;

import com.cts.utils.UserContextHolder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class SimpleSourceBean {
    private final Source source;

    public void publishOrganizationChange(Action action, Long organizationId) {
        log.info("Sending Kafka message {} for Organization id {}", action, organizationId);
        OrganizationChangeModel model = OrganizationChangeModel.builder()
                                                               .type(OrganizationChangeModel.class.getTypeName())
                                                               .action(action.toString())
                                                               .organizationId(organizationId)
                                                               .correlationId(UserContextHolder.getContext()
                                                                                               .getCorrelationId())
                                                               .build();
        source.output()
              .send(MessageBuilder.withPayload(model)
                                  .build());
    }
}
