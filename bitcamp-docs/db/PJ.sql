-- 프로젝트
DROP TABLE IF EXISTS proj RESTRICT;

-- 팀원
DROP TABLE IF EXISTS team_mem RESTRICT;

-- 고객
DROP TABLE IF EXISTS cus RESTRICT;

-- 프로젝트자료
DROP TABLE IF EXISTS proj_data RESTRICT;

-- 비용
DROP TABLE IF EXISTS pay RESTRICT;

-- 팀프로젝트
DROP TABLE IF EXISTS team_proj RESTRICT;

-- 고객프로젝트
DROP TABLE IF EXISTS cus_proj RESTRICT;

-- 팀고객
DROP TABLE IF EXISTS team_cus RESTRICT;

-- 설계
DROP TABLE IF EXISTS des RESTRICT;

-- 테스트
DROP TABLE IF EXISTS test RESTRICT;

-- 팀
DROP TABLE IF EXISTS team RESTRICT;

-- 사용자
DROP TABLE IF EXISTS user RESTRICT;

-- 프로젝트
CREATE TABLE proj (
  proj_id INTEGER     NOT NULL COMMENT '프로젝트번호', -- 프로젝트번호
  pay_id  INTEGER     NOT NULL COMMENT '비용번호', -- 비용번호
  name    VARCHAR(50) NOT NULL COMMENT '이름', -- 이름
  cons    TEXT        NOT NULL COMMENT '내용', -- 내용
  type    TEXT        NOT NULL COMMENT '분류', -- 분류
  det     TEXT        NULL     COMMENT '세부사항', -- 세부사항
  equ     VARCHAR(50) NOT NULL COMMENT '사용장비' -- 사용장비
)
COMMENT '프로젝트';

-- 프로젝트
ALTER TABLE proj
  ADD CONSTRAINT PK_proj -- 프로젝트 기본키
    PRIMARY KEY (
      proj_id -- 프로젝트번호
    );

-- 프로젝트 인덱스
CREATE INDEX IX_proj
  ON proj( -- 프로젝트
    name ASC -- 이름
  );

ALTER TABLE proj
  MODIFY COLUMN proj_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '프로젝트번호';

-- 팀원
CREATE TABLE team_mem (
  id      INTEGER     NOT NULL COMMENT '팀원번호', -- 팀원번호
  user_id INTEGER     NOT NULL COMMENT '사용자번호', -- 사용자번호
  team_id INTEGER     NOT NULL COMMENT '팀번호', -- 팀번호
  rol     VARCHAR(30) NOT NULL COMMENT '역할', -- 역할
  pay     INTEGER     NOT NULL COMMENT '월급' -- 월급
)
COMMENT '팀원';

-- 팀원
ALTER TABLE team_mem
  ADD CONSTRAINT PK_team_mem -- 팀원 기본키
    PRIMARY KEY (
      id,      -- 팀원번호
      user_id  -- 사용자번호
    );

ALTER TABLE team_mem
  MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT COMMENT '팀원번호';

-- 고객
CREATE TABLE cus (
  cus_id  INTEGER NOT NULL COMMENT '고객번호', -- 고객번호
  user_id INTEGER NOT NULL COMMENT '사용자번호', -- 사용자번호
  need    TEXT    NOT NULL COMMENT '요구사항' -- 요구사항
)
COMMENT '고객';

-- 고객
ALTER TABLE cus
  ADD CONSTRAINT PK_cus -- 고객 기본키
    PRIMARY KEY (
      cus_id,  -- 고객번호
      user_id  -- 사용자번호
    );

ALTER TABLE cus
  MODIFY COLUMN cus_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '고객번호';

-- 프로젝트자료
CREATE TABLE proj_data (
  proj_data_id INTEGER      NOT NULL COMMENT '프로젝트자료번호', -- 프로젝트자료번호
  proj_id      INTEGER      NOT NULL COMMENT '프로젝트번호', -- 프로젝트번호
  phot         VARCHAR(255) NULL     COMMENT '프로젝트사진', -- 프로젝트사진
  text         VARCHAR(255) NULL     COMMENT '프로젝트문서', -- 프로젝트문서
  ser          VARCHAR(255) NULL     COMMENT '프로젝트소스' -- 프로젝트소스
)
COMMENT '프로젝트자료';

-- 프로젝트자료
ALTER TABLE proj_data
  ADD CONSTRAINT PK_proj_data -- 프로젝트자료 기본키
    PRIMARY KEY (
      proj_data_id -- 프로젝트자료번호
    );

ALTER TABLE proj_data
  MODIFY COLUMN proj_data_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '프로젝트자료번호';

-- 비용
CREATE TABLE pay (
  pay_id   INTEGER     NOT NULL COMMENT '비용번호', -- 비용번호
  p_p      INTEGER     NOT NULL COMMENT '프로젝트비용', -- 프로젝트비용
  t_f      BOOLEAN     NOT NULL COMMENT '결제유무', -- 결제유무
  stat     BOOLEAN     NOT NULL COMMENT '결제상태', -- 결제상태
  type     VARCHAR(50) NOT NULL COMMENT '결제유형', -- 결제유형
  date     DATE        NULL     COMMENT '결제날짜', -- 결제날짜
  team_pay INTEGER     NULL     COMMENT '팀내부사용금액', -- 팀내부사용금액
  oth_pay  INTEGER     NULL     COMMENT '기타비용' -- 기타비용
)
COMMENT '비용';

-- 비용
ALTER TABLE pay
  ADD CONSTRAINT PK_pay -- 비용 기본키
    PRIMARY KEY (
      pay_id -- 비용번호
    );

ALTER TABLE pay
  MODIFY COLUMN pay_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '비용번호';

-- 팀프로젝트
CREATE TABLE team_proj (
  proj_id INTEGER NOT NULL COMMENT '프로젝트번호', -- 프로젝트번호
  team_id INTEGER NOT NULL COMMENT '팀번호' -- 팀번호
)
COMMENT '팀프로젝트';

-- 팀프로젝트
ALTER TABLE team_proj
  ADD CONSTRAINT PK_team_proj -- 팀프로젝트 기본키
    PRIMARY KEY (
      proj_id, -- 프로젝트번호
      team_id  -- 팀번호
    );

-- 고객프로젝트
CREATE TABLE cus_proj (
  cus_id  INTEGER NOT NULL COMMENT '고객번호', -- 고객번호
  proj_id INTEGER NOT NULL COMMENT '프로젝트번호', -- 프로젝트번호
  user_id INTEGER NOT NULL COMMENT '사용자번호' -- 사용자번호
)
COMMENT '고객프로젝트';

-- 고객프로젝트
ALTER TABLE cus_proj
  ADD CONSTRAINT PK_cus_proj -- 고객프로젝트 기본키
    PRIMARY KEY (
      cus_id,  -- 고객번호
      proj_id, -- 프로젝트번호
      user_id  -- 사용자번호
    );

-- 팀고객
CREATE TABLE team_cus (
  team_id INTEGER NOT NULL COMMENT '팀번호', -- 팀번호
  cus_id  INTEGER NOT NULL COMMENT '고객번호', -- 고객번호
  user_id INTEGER NOT NULL COMMENT '사용자번호' -- 사용자번호
)
COMMENT '팀고객';

-- 팀고객
ALTER TABLE team_cus
  ADD CONSTRAINT PK_team_cus -- 팀고객 기본키
    PRIMARY KEY (
      team_id, -- 팀번호
      cus_id,  -- 고객번호
      user_id  -- 사용자번호
    );

-- 설계
CREATE TABLE des (
  des_id       INTEGER NOT NULL COMMENT '설계번호', -- 설계번호
  proj_data_id INTEGER NOT NULL COMMENT '프로젝트자료번호', -- 프로젝트자료번호
  st_dy        DATE    NOT NULL COMMENT '시작일', -- 시작일
  end_dy       DATE    NOT NULL COMMENT '종료일', -- 종료일
  n_p          INTEGER NOT NULL COMMENT '참여인원' -- 참여인원
)
COMMENT '설계';

-- 설계
ALTER TABLE des
  ADD CONSTRAINT PK_des -- 설계 기본키
    PRIMARY KEY (
      des_id -- 설계번호
    );

ALTER TABLE des
  MODIFY COLUMN des_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '설계번호';

-- 테스트
CREATE TABLE test (
  test_id      INTEGER     NOT NULL COMMENT '테스트번호', -- 테스트번호
  proj_data_id INTEGER     NOT NULL COMMENT '프로젝트자료번호', -- 프로젝트자료번호
  name         VARCHAR(50) NOT NULL COMMENT '이름', -- 이름
  cons         TEXT        NOT NULL COMMENT '내용', -- 내용
  date         DATE        NOT NULL COMMENT '날짜', -- 날짜
  type         TEXT        NOT NULL COMMENT '종류' -- 종류
)
COMMENT '테스트';

-- 테스트
ALTER TABLE test
  ADD CONSTRAINT PK_test -- 테스트 기본키
    PRIMARY KEY (
      test_id -- 테스트번호
    );

-- 팀
CREATE TABLE team (
  team_id INTEGER NOT NULL COMMENT '팀번호', -- 팀번호
  fix     TEXT    NULL     COMMENT '수정사항', -- 수정사항
  det     TEXT    NOT NULL COMMENT '세부계획', -- 세부계획
  pla     TEXT    NOT NULL COMMENT '진행장소' -- 진행장소
)
COMMENT '팀';

-- 팀
ALTER TABLE team
  ADD CONSTRAINT PK_team -- 팀 기본키
    PRIMARY KEY (
      team_id -- 팀번호
    );

ALTER TABLE team
  MODIFY COLUMN team_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '팀번호';

-- 사용자
CREATE TABLE user (
  user_id INTEGER      NOT NULL COMMENT '사용자번호', -- 사용자번호
  name    VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
  tel     VARCHAR(30)  NOT NULL COMMENT '전화번호', -- 전화번호
  email   VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
  lev     VARCHAR(30)  NOT NULL COMMENT '직책', -- 직책
  phot    VARCHAR(255) NULL     COMMENT '사진' -- 사진
)
COMMENT '사용자';

-- 사용자
ALTER TABLE user
  ADD CONSTRAINT PK_user -- 사용자 기본키
    PRIMARY KEY (
      user_id -- 사용자번호
    );

-- 사용자 유니크 인덱스
CREATE UNIQUE INDEX UIX_user
  ON user ( -- 사용자
    email ASC -- 이메일
  );

-- 사용자 인덱스
CREATE INDEX IX_user
  ON user( -- 사용자
    name ASC -- 이름
  );

ALTER TABLE user
  MODIFY COLUMN user_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '사용자번호';

-- 프로젝트
ALTER TABLE proj
  ADD CONSTRAINT FK_pay_TO_proj -- 비용 -> 프로젝트
    FOREIGN KEY (
      pay_id -- 비용번호
    )
    REFERENCES pay ( -- 비용
      pay_id -- 비용번호
    );

-- 팀원
ALTER TABLE team_mem
  ADD CONSTRAINT FK_team_TO_team_mem -- 팀 -> 팀원
    FOREIGN KEY (
      team_id -- 팀번호
    )
    REFERENCES team ( -- 팀
      team_id -- 팀번호
    );

-- 팀원
ALTER TABLE team_mem
  ADD CONSTRAINT FK_user_TO_team_mem -- 사용자 -> 팀원
    FOREIGN KEY (
      user_id -- 사용자번호
    )
    REFERENCES user ( -- 사용자
      user_id -- 사용자번호
    );

-- 고객
ALTER TABLE cus
  ADD CONSTRAINT FK_user_TO_cus -- 사용자 -> 고객
    FOREIGN KEY (
      user_id -- 사용자번호
    )
    REFERENCES user ( -- 사용자
      user_id -- 사용자번호
    );

-- 프로젝트자료
ALTER TABLE proj_data
  ADD CONSTRAINT FK_proj_TO_proj_data -- 프로젝트 -> 프로젝트자료
    FOREIGN KEY (
      proj_id -- 프로젝트번호
    )
    REFERENCES proj ( -- 프로젝트
      proj_id -- 프로젝트번호
    );

-- 팀프로젝트
ALTER TABLE team_proj
  ADD CONSTRAINT FK_proj_TO_team_proj -- 프로젝트 -> 팀프로젝트
    FOREIGN KEY (
      proj_id -- 프로젝트번호
    )
    REFERENCES proj ( -- 프로젝트
      proj_id -- 프로젝트번호
    );

-- 팀프로젝트
ALTER TABLE team_proj
  ADD CONSTRAINT FK_team_TO_team_proj -- 팀 -> 팀프로젝트
    FOREIGN KEY (
      team_id -- 팀번호
    )
    REFERENCES team ( -- 팀
      team_id -- 팀번호
    );

-- 고객프로젝트
ALTER TABLE cus_proj
  ADD CONSTRAINT FK_cus_TO_cus_proj -- 고객 -> 고객프로젝트
    FOREIGN KEY (
      cus_id,  -- 고객번호
      user_id  -- 사용자번호
    )
    REFERENCES cus ( -- 고객
      cus_id,  -- 고객번호
      user_id  -- 사용자번호
    );

-- 고객프로젝트
ALTER TABLE cus_proj
  ADD CONSTRAINT FK_proj_TO_cus_proj -- 프로젝트 -> 고객프로젝트
    FOREIGN KEY (
      proj_id -- 프로젝트번호
    )
    REFERENCES proj ( -- 프로젝트
      proj_id -- 프로젝트번호
    );

-- 팀고객
ALTER TABLE team_cus
  ADD CONSTRAINT FK_team_TO_team_cus -- 팀 -> 팀고객
    FOREIGN KEY (
      team_id -- 팀번호
    )
    REFERENCES team ( -- 팀
      team_id -- 팀번호
    );

-- 팀고객
ALTER TABLE team_cus
  ADD CONSTRAINT FK_cus_TO_team_cus -- 고객 -> 팀고객
    FOREIGN KEY (
      cus_id,  -- 고객번호
      user_id  -- 사용자번호
    )
    REFERENCES cus ( -- 고객
      cus_id,  -- 고객번호
      user_id  -- 사용자번호
    );

-- 설계
ALTER TABLE des
  ADD CONSTRAINT FK_proj_data_TO_des -- 프로젝트자료 -> 설계
    FOREIGN KEY (
      proj_data_id -- 프로젝트자료번호
    )
    REFERENCES proj_data ( -- 프로젝트자료
      proj_data_id -- 프로젝트자료번호
    );

-- 테스트
ALTER TABLE test
  ADD CONSTRAINT FK_proj_data_TO_test -- 프로젝트자료 -> 테스트
    FOREIGN KEY (
      proj_data_id -- 프로젝트자료번호
    )
    REFERENCES proj_data ( -- 프로젝트자료
      proj_data_id -- 프로젝트자료번호
    );