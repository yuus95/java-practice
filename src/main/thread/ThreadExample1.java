package main.thread;


/**
 * task2 Start
 * task1 Start
 * 200 201 202 100 203 101 102 103 104 105 204 205 206 207 106 208 107 209 108 210 109 211 212 213 110 214 111 112 113 114 115 215 116 216 117 217 118 218 119 219 120 220 121 221 122 222 123 223 124 224 125 225 126 226 127 227 128 228 129 229 130 230 231 232 233 234 235 236 237 238 239 240 241 242 243 131 132 244 133 245 134 246 135 247 136 248 137 249 138 250 139 251 140 252 141 253 142 254 143 255 144 256 145 257 146 258 147 259 148 260 149 261 150 262 263 264 265 151 266 152 267 153 268 154 269 155 270 156 271 157 272 158 273 159 160 161 162 274 163 275 164 276 165 277 166 278 167 279 168 280 169 281 282 283 284 285 170 286 171 287 172 288 289 290 291 292 293 294 295 296 297 298 299 173
 * task2 done
 * task3 Start
 * 174 175 176 177 178 179 180 181 182 183 184 185 186 187 188 189 190 191 192 193 194 195 196 197 198 199 300
 * task1 done
 * 301 302 303 304 305 306 307 308 309 310 311 312 313 314 315 316 317 318 319 320 321 322 323 324 325 326 327 328 329 330 331 332 333 334 335 336 337 338 339 340 341 342 343 344 345 346 347 348 349 350 351 352 353 354 355 356 357 358 359 360 361 362 363 364 365 366 367 368 369 370 371 372 373 374 375 376 377 378 379 380 381 382 383 384 385 386 387 388 389 390 391 392 393 394 395 396 397 398 399
 * task3 done
 */

/**
 * A main.thread is a main.thread of execution in a program. The Java Virtual Machine allows an application to have multiple threads of execution running concurrently.
 * <p>
 * 쓰레드 시작 상태를 NEW 라고 한다.
 * NEW : 스레드 가 start() 메소드를 실행하기 전 상태
 * RUNABLE : 작업준비를 마쳤지만 다른 Thread가 우선적으로 실행되고 있는 상태를 의미한다.(ex - 스레드가 준비됐지만 특정스레드2가 200을 호출하고 있어서 대기상태일 경우)
 * RUNNING : 스레드가 특정 상태일 때 를 일컫는다. (ex - 스레드2에서 200을 정상적으로 호출할 때 RUNNING )
 * BLOCK: 외부의 데이터베이스나. 어떤 입력을 위해 대기하고 있거나, 실행이 완료되지 않은 다른 Thread로부터 데이터를 입력받아야 하는 상황을 뜻한다.
 * TERMINATED/DEAD : 모두 실행이 완료되었을 경우를 의미한다.
 * extends main.thread
 * implements Runnable
 */

/**
 * sleep() : 스레드를 대기상태로 만들거나 잠재운다.
 * yield();
 * 동기화는 overHead 가 심하다.
 */

class Task1 extends Thread {
    public void run() {
        System.out.println("task1 Start");
        for (int i = 100; i <= 199; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\n task1 done");
    }
}

class Task2 extends Thread {
    public void run() {
        System.out.println("task2 Start");
        for (int i = 200; i <= 299; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\n task2 done");
    }
}

public class ThreadExample1 {
    public static void main(String[] args) throws InterruptedException {

        // task1
        Task1 task1 = new Task1();
        task1.start();

        // 단지 요청사항 받아들일 수 있고 받아들이지 않을수도 있다. (추천사항)
        //  1 로 갈 수록 우선순위가 낮음
        // 10으로 갈 수록 우선순위가 높음(10이 맥시멈)
        task1.setPriority(1);
        Task2 task2 = new Task2();
        task2.start();

        // Waits for this main.thread to die.
        // join 메서드를 호출한 테스크가 죽을 때 까지 대기한다.
        task1.join();
        //task3
        System.out.println("task3 Start");
        for (int i = 300; i <= 399; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\n task3 done");

    }
}

