package it.ul.restaranserverbackend2.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResStatistics {
    private Integer categorySize;
    private Integer productSize;
    private Integer buySize;
    private Integer protcent;
}
