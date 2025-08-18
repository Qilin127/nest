package com.nest.renting.web.app.vo.graph;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * GraphVo represents image information, including the image name and URL.
 */
@Data
@Schema(description = "Image Information")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GraphVo implements Serializable {

    @Schema(description = "Image Name")
    private String name;

    @Schema(description = "Image URL")
    private String url;

}
