package com.example.passbatch.job.pass;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class AddPassesJobConfig {

    private final AddPassesTasklet addPassesTasklet;

    private final PlatformTransactionManager platformTransactionManager;

    @Bean
    public Job addPassesJob(JobRepository jobRepository) {
        return new JobBuilder("addPassesJob", jobRepository)
                .start(addPassesStep(jobRepository))
                .build();
    }

    @Bean
    public Step addPassesStep(JobRepository jobRepository) {
        return new StepBuilder("addPassesStep", jobRepository)
                .tasklet(addPassesTasklet, platformTransactionManager)
                .build();
    }
}
