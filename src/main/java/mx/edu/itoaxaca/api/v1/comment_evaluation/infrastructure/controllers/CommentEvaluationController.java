package mx.edu.itoaxaca.api.v1.comment_evaluation.infrastructure.controllers;

import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.comment_evaluation.application.CommentEvaluationCreate;
import mx.edu.itoaxaca.api.v1.comment_evaluation.application.CommentEvaluationDestroy;
import mx.edu.itoaxaca.api.v1.comment_evaluation.application.CommentEvaluationGetAll;
import mx.edu.itoaxaca.api.v1.comment_evaluation.application.CommentEvaluationGetById;
import mx.edu.itoaxaca.api.v1.comment_evaluation.application.CommentEvaluationUpdate;
import mx.edu.itoaxaca.api.v1.comment_evaluation.domain.CommentEvaluation;
import mx.edu.itoaxaca.api.v1.comment_evaluation.domain.CommentEvaluationRepository;
import mx.edu.itoaxaca.api.v1.comment_evaluation.domain.CommentEvaluationStoreRequest;
import mx.edu.itoaxaca.api.v1.comment_evaluation.domain.CommentEvaluationUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Routes.API_V1_COMMENT_EVALUATION_BASE)
@RequiredArgsConstructor
public class CommentEvaluationController {
    private final CommentEvaluationRepository repo;

    @GetMapping
    Page<CommentEvaluation> index() {
        return CommentEvaluationGetAll.run(PageRequest.of(0, 10), repo);
    }

    @GetMapping(value = "/{id}")
    CommentEvaluation show(@PathVariable UUID id) {
        return CommentEvaluationGetById.run(repo, id);
    }

    @PostMapping
    CommentEvaluation store(@Valid @RequestBody CommentEvaluationStoreRequest request) {
        return CommentEvaluationCreate.run(repo, request.asCommentEvaluation());
    }

    @PutMapping(value = "/{id}")
    CommentEvaluation update(
        @PathVariable UUID id,
        @Valid @RequestBody CommentEvaluationUpdateRequest request
    ) {
        return CommentEvaluationUpdate.run(repo, id, request.asCommentEvaluation());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void destroy(@PathVariable UUID id) {
        CommentEvaluationDestroy.run(repo, id);
    }
}
