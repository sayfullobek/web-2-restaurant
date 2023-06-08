package it.ul.restaranserverbackend2.payload;

import it.ul.restaranserverbackend2.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetData {
    private User user;
    private ResToken resToken;
}
