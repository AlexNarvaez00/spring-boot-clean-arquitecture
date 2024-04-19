package mx.edu.itoaxaca.api.v1.comments_evaluation_group.infrastructure.controllers;

import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.comments_evaluation_group.application.CommentEvaluationGroupCreate;
import mx.edu.itoaxaca.api.v1.comments_evaluation_group.application.CommentEvaluationGroupDelete;
import mx.edu.itoaxaca.api.v1.comments_evaluation_group.application.CommentEvaluationGroupGetById;
import mx.edu.itoaxaca.api.v1.comments_evaluation_group.application.CommentEvaluationGroupUpdate;
import mx.edu.itoaxaca.api.v1.comments_evaluation_group.domain.CommentEvaluationGroup;
import mx.edu.itoaxaca.api.v1.comments_evaluation_group.domain.CommentEvaluationGroupRepository;
import mx.edu.itoaxaca.api.v1.comments_evaluation_group.domain.CommentEvaluationGroupStoreRequest;
import mx.edu.itoaxaca.api.v1.comments_evaluation_group.domain.CommentEvaluationGroupUpdateRequest;
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
@RequiredArgsConstructor
@RequestMapping(value = Routes.API_V1_COMMENT_EVALUATION_GROUP_BASE)
public class CommentEvaluationGroupController {

    private final CommentEvaluationGroupRepository repo;

    @GetMapping(value = "")
    public Page<CommentEvaluationGroup> index() {
        return this.repo.findAll(PageRequest.of(0, 10));
    }

    @GetMapping(value = "/{id}")
    public CommentEvaluationGroup show(@PathVariable UUID id) {
        return CommentEvaluationGroupGetById.run(repo, id);
    }

    @PostMapping(value = "")
    public CommentEvaluationGroup store(
        @Valid @RequestBody CommentEvaluationGroupStoreRequest request
    ) {
        return CommentEvaluationGroupCreate.run(repo, request.asCommentEvaluationGroup());
    }

    @PutMapping(value = "/{id}")
    public CommentEvaluationGroup update(
        @PathVariable UUID id,
        @Valid @RequestBody CommentEvaluationGroupUpdateRequest request
    ) {
        return CommentEvaluationGroupUpdate.run(repo, id, request.asCommentEvaluationGroup());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable UUID id) {
        CommentEvaluationGroupDelete.run(repo, id);
    }
}
