package egovframework.itman.asset.dto;

import egovframework.itman.state.dto.StateDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class AssetStateDto {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request {
        private Long assetStateId;

        private StateDto.Request state;

        private Boolean del;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long assetStateId;

        private StateDto.Response state;

        private Boolean del;

        private LocalDateTime createdDate;
        private LocalDateTime modifiedDate;
    }
}
