package com.leokenzley.templatesecapi.core.usecase.users;

import com.leokenzley.templatesecapi.core.domain.UserDomain;

public interface DeleteUserUseCase {
    void execute(Long id);
}
