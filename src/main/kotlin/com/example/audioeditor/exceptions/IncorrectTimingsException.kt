package com.example.audioeditor.exceptions

import org.springframework.http.HttpStatus

class IncorrectTimingsException(): BaseException(
    HttpStatus.BAD_REQUEST,
    ApiError(
        errorCode = "incorrect.timings",
        description = "incorrect timings to edit file"
    )
)